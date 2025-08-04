import 'package:file_deck/utils/method_channel_handler.dart';
import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    MethodChannelHelper.getAllFolder();
    return Scaffold(
      appBar: AppBar(title: Text("File Deck"), backgroundColor: Colors.black),
      body: Center(child: Text("HAHAHAHAHA")),
    );
  }
}
