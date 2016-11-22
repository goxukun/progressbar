#include <stdio.h>
#include <string.h>
#include <jni.h>
#include <android/log.h>


#define  LOG_TAG    "【C_LOG】"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)


JNIEXPORT jstring JNICALL java_com_xukun_forever_jintest_MainActivity_getStrignFromJNI(JNIEnv *env,jobject thiz)
{
    LOGI("调用 C getStringFromJNI() 方法\n");
    char* str = "Hello Java! 我是一只来自C世界的Dog，汪!!!";
    return (*env)->NewStringUTF(env, str);
}

JNIEXPORT void JNICALL Java_com_dgk_jnitest_MainActivity_setStringToJNI (JNIEnv* env, jobject thiz, jstring str)
{
    LOGI("调用 C setStringFromJNI() 方法\n");
    char* string = (char*)(*env)->GetStringUTFChars(env, str, NULL);
    LOGI("%s\n", string);
    (*env)->ReleaseStringUTFChars(env, str, string);
}