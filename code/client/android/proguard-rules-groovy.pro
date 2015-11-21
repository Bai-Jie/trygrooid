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
