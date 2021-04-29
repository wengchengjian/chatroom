package com.wcj.chat.start.client;

import com.wcj.chat.client.FaceToFaceClient;
import com.wcj.chat.start.Start;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:18
 * @Version 1.0.0
 */
public class ClientStart implements Start {

    @Override
    public void start() throws Exception {
        FaceToFaceClient faceToFaceClient = new FaceToFaceClient(DEFAULT_SERVER_PORT,DEFAULT_SERVER_HOST);
        faceToFaceClient.run();
    }
}
