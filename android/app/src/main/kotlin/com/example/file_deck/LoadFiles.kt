package com.example.file_deck

import java.io.File

class LoadFiles {
    companion object{

        fun getAllFolders(path : String) : List<File>{
            val dir = File(path)
            if (dir.exists() && dir.isDirectory){
                return dir.listFiles()?.filter { it.isDirectory } ?: emptyList()
            }
            return emptyList()
        }
    }
}