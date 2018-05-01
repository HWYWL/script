package com.yi.script.utils;

import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.sftp.FileAttributes;

import java.io.*;

/**
 * 通过ssh读取服务器文件
 * @author YI
 * @date 2018-5-1 01:33:06
 */
public class SshGetFile {

    public static FileAttributes getMessage(String sshHost, int sshPort, String sshUser, String sshPass, String path) throws IOException {
        SshClient client = new SshClient();
        FileAttributes fileAttributes = null;

        try {
            client.connect(sshHost, sshPort);
            // 设置用户名和密码
            PasswordAuthenticationClient pwd = new PasswordAuthenticationClient();
            pwd.setUsername(sshUser);
            pwd.setPassword(sshPass);

            // 如果连接完成
            if (client.authenticate(pwd) == AuthenticationProtocolState.COMPLETE) {
                fileAttributes = client.openSftpClient().get(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileAttributes;
    }
}
