import 'package:file_deck/models/folder.dart';
import 'package:flutter/services.dart';

class MethodChannelHelper {
  static const _methodChannel = MethodChannel("file-deck-methodChannel");

  static Future<void> getAllFolder() async {
    final List result = await _methodChannel.invokeMethod("getFolders");

    final folders = result
        .map((e) => Map<String, dynamic>.from(e))
        .map((map) => Folder.fromMap(map))
        .toList();

    print(folders.length);

    for (var folder in folders) {
      print("${folder.isHidden}");
    }
  }
}
