# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class id.deval.core.** { *; }
-keepclassmembers class id.deval.core.** { *; }

# Preserve generic type signatures for Gson TypeToken
-keepattributes Signature
-keepclassmembers class com.google.gson.reflect.TypeToken { *; }
-keepclassmembers class * implements com.google.gson.reflect.TypeToken { *; }
-keepclassmembers class * extends com.google.gson.TypeAdapter { *; }

# Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items).
 -keep,allowobfuscation,allowshrinking interface retrofit2.Call
 -keep,allowobfuscation,allowshrinking class retrofit2.Response

 # With R8 full mode generic signatures are stripped for classes that are not
 # kept. Suspend functions are wrapped in continuations where the type argument
 # is used.
 -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# Keep model classes (replace with your package path)
-keep class id.deval.core.model.** { *; }

# Keep all Gson related classes
-keep class com.google.gson.** { *; }
# Optionally, keep Dagger/Hilt related classes
-keep class dagger.hilt.** { *; }
-keep class dagger.Module { *; }

-dontwarn java.lang.invoke.StringConcatFactory
