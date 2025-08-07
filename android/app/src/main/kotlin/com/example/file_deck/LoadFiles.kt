package com.example.file_deck

import java.io.File

class LoadFiles {
    companion object{

        fun getAllFolders(path : String) : List<Map<String,Any>>{

            val folderList = mutableListOf<Map<String,Any>>()
            val dir = File(path)

            if (dir.exists() && dir.isDirectory){
                val folders = dir.listFiles()?.filter { it.isDirectory } ?: emptyList()

                for (folder in folders){
                    val folderMap = mapOf(
                        "name" to folder.name,
//                        "size" to folderSize(folder).toDouble(),
//                        "freeSpace" to folder.freeSpace.toDouble(),
                        "path" to folder.absolutePath,
                        "isHidden" to folder.isHidden,
//                        "parentFile" to (folder.parentFile != null),
                    )
                    folderList.add(folderMap)
                }
            }
            return folderList
        }
        fun folderSize(dir: File): Long {
            var size: Long = 0
            if (dir.isDirectory) {
                dir.listFiles()?.forEach {
                    size+= if (it.isFile) it.length() else folderSize(it)
                }
            }
            return size
        }
    }
}