package Control;

import DT.Account;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Luồng riêng dùng để giao tiếp với mỗi user
// Object để synchronize các hàm cần thiết
// Các client đều có chung object này được thừa hưởng từ chính server
public class Handler implements Runnable {

    private Object lock;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private Account account;

    public Handler(Socket socket1, Account account1, Object lock1) throws IOException {
        this.socket = socket1;
        this.account = account1;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.lock = lock1;
    }

    public String getUsername() {
        return this.account.getUserName();
    }

    public String getPassword() {
        return this.account.getPassword();
    }

    public DataOutputStream getOutput() {
        return this.output;
    }

    public String getAvatr() {
        return account.getAvatar();
    }

    public void setPassword(String pass) {
        account.setPassword(pass);
    }

    public void setAvatar(String Avatar) {
        account.setAvatar(Avatar);
    }

    public void run() {

        while (true) {
            try {
                String message = null;
                // Đọc yêu cầu từ user
                message = input.readUTF();

                // Yêu cầu đăng xuất từ user
                if (message.equals("Log out")) {

                    // Đóng socket và chuyển trạng thái thành offline
                    Server.LogOutAccount(this);
                    socket.close();
                    // Thông báo cho các user khác cập nhật danh sách người dùng trực tuyến
                    Server.updateOnlineUsers();
                    break;

                } // Yêu cầu gửi tin nhắn dạng văn bản
                else if (message.equals("Text")) {
                    String sender = input.readUTF();
                    String receiver = input.readUTF();
                    String content = input.readUTF();
                    for (Handler client : Server.clients) {
                        if (client.getUsername().equals(receiver)) {
                            synchronized (lock) {
                                client.getOutput().writeUTF("Text");
                                client.getOutput().writeUTF(sender);
                                client.getOutput().writeUTF(receiver);
                                client.getOutput().writeUTF(content);
                                client.getOutput().flush();
                                break;
                            }
                        }
                    }
                }

            } catch (IOException e) {
                // e.printStackTrace();
            }
        }
    }
}
