package com.wcj.chat.start.server;

import com.wcj.chat.server.FaceToFaceServer;
import com.wcj.chat.start.Start;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:17
 * @Version 1.0.0
 */
public class ServerStart implements Start {

    @Override
    public void start() throws Exception {
        FaceToFaceServer faceToFaceServer = new FaceToFaceServer(DEFAULT_SERVER_PORT);
        faceToFaceServer.run();
    }
}
