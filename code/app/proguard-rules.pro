# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\program_green\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


# Groovy
# added by Bai Jie
#need this?-keep,allowshrinking,allowoptimization class org.codehaus.groovy.**
-keep,allowshrinking,allowoptimization class groovy**
# copy from https://github.com/melix/gr8confagenda/blob/17722d8048a2c9bbd3422b23126c696916f68a87/gr8confagenda/proguard-rules.txt
#-dontobfuscate # removed by Bai Jie
-dontwarn org.codehaus.groovy.**
-dontwarn groovy**
-keep class org.codehaus.groovy.vmplugin.**
-keep class org.codehaus.groovy.runtime.dgm*
-keepclassmembers class org.codehaus.groovy.runtime.dgm* {*;}
-keepclassmembers class ** implements org.codehaus.groovy.runtime.GeneratedClosure {*;}
-keepclassmembers class org.codehaus.groovy.reflection.GroovyClassValue* {*;}
