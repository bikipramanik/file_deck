import 'package:flutter/services.dart';

class MethodChannelHelper {
  static const _methodChannel = MethodChannel("file-deck-methodChannel");

  static Future<void> getAllFolder() async {
    final result = await _methodChannel.invokeMethod("getFolders");

    for (var folder in result) {
      print("$folder");
    }
  }
}
