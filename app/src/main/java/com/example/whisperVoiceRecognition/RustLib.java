package com.example.whisperVoiceRecognition;

import java.nio.ByteBuffer;

public class RustLib {

    static {

        System.loadLibrary("rust");

        RustLib.initLogger();
    }

    //
//    public void retrieveAssetPub(AssetManager assetManager) {
//        retrieveAsset(assetManager);
//    }
//
//    private static native String hello(String input);
//    private static native void retrieveAsset(AssetManager assetManager);
//    public static native void sampleAudio();
//
//    /**
//     * @param context ApplicationContext
//     * @param deviceId AudioManager Device id for the microphone
//     * @param sampleRate AudioManager sample rate for the device
//     * @param channels AudioManager Channels for the device
//     */
    public static native void initLogger();

    public native boolean createLogMelSpectrogramFromAudioBytes(ByteBuffer audio, ByteBuffer output);


    public static native void init();

    public static native void uninit();

    public static native boolean startRecording(int deviceId, int sampleRate, int channels);

    public static native ByteBuffer endRecordingGetSpectrogram();

    public static native boolean abortRecording();


}
