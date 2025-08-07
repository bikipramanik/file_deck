package com.example.file_deck

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import androidx.core.net.toUri
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel


class MainActivity : FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            "file-deck-methodChannel"
        ).setMethodCallHandler { call, result ->
            if (call.method == "getFolders") {

                val folders = LoadFiles.getAllFolders("/storage/emulated/0/")

//                val folders = mutableListOf<Map<String, Any>>(
//
//                    mapOf<String, Any>(
//                        "name" to "name1",
////                        "size" to folderSize(folder).toDouble(),
//                        "freeSpace" to 2.5,
//                        "path" to "path",
//                        "isHidden" to true,
//                        "parentFile" to "parentFile",
//                    ),
//                    mapOf<String, Any>(
//                        "name" to "name2",
////                        "size" to folderSize(folder).toDouble(),
//                        "freeSpace" to 2.5,
//                        "path" to "path3",
//                        "isHidden" to true,
//                        "parentFile" to "parentFile",
//                    ),
//                    mapOf<String, Any>(
//                        "name" to "name4",
////                        "size" to folderSize(folder).toDouble(),
//                        "freeSpace" to 2.5,
//                        "path" to "path",
//                        "isHidden" to true,
//                        "parentFile" to "parentFile",
//                    ),
//                    mapOf<String, Any>(
//                        "name" to "name5",
////                        "size" to folderSize(folder).toDouble(),
//                        "freeSpace" to 2.5,
//                        "path" to "path",
//                        "isHidden" to true,
//                        "parentFile" to "parentFile",
//                    ),
//                    mapOf<String, Any>(
//                        "name" to "name6",
////                        "size" to folderSize(folder).toDouble(),
//                        "freeSpace" to 2.5,
//                        "path" to "path",
//                        "isHidden" to true,
//                        "parentFile" to "parentFile",
//                    ),


                result.success(folders)
            } else {
                result.notImplemented()
            }   

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermission(context)
    }

    override fun onResume() {
        super.onResume()
        requestPermission(context)
    }


    private fun requestPermission(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Toast.makeText(
                    context,
                    "Need permission to access all files",
                    Toast.LENGTH_LONG
                ).show()
                try {
                    val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                    intent.data = "package:${context.packageName}".toUri()
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(
                        context,
                        "Search it $packageName and allow.\n${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    try {
                        val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                        intent.data = "package:${context.packageName}".toUri()
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(intent)
                    } catch (f: Exception) {
                        Toast.makeText(
                            context,
                            "Unable to open settings. Please grant the permission manually.\n${f.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}