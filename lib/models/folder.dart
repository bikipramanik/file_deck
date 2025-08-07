class Folder {
  Folder({
    required this.name,
    // required this.size,
    required this.path,
    required this.isHidden,
    // required this.freeSpace,
    // required this.parentFile,
  });
  final String name;
  // final double size;
  // final double freeSpace;
  final String path;
  final bool isHidden;
  // final String parentFile;

  factory Folder.fromMap(Map<String, dynamic> map) {
    return Folder(
      name: map['name'] ?? " ",
      // size: (map['size'] as num).toDouble(),
      path: map['path'] ?? " ",
      isHidden: map['isHidden'] ?? false,
      // freeSpace: (map['freeSpace'] as num).toDouble(),
      // parentFile: map['parentFile'] ?? " ",
    );
  }
}
