#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_nativelib_NativeLib_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndkuse_MainActivity_getStringJNI(JNIEnv *env, jobject thiz) {
    std::string someString = "Some string from C++ library";
    return env->NewStringUTF(someString.c_str());
}