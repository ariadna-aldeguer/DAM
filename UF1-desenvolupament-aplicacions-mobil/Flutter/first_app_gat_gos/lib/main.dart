import 'package:flutter/material.dart';
void main() => runApp(const MyApp());
class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    var title = 'App per fer proves';
    return MaterialApp(
      title: title,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Aplicació d'Ari"),
          foregroundColor: Colors.black,
          backgroundColor: Colors.limeAccent[100]
        ),
        body: 
        Column(children: [
          Row(
            children: [
              Image.network(
                'https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/article/600033325bafe872e9c3bf12/gatito_0.jpg',
                width: 300,
                height: 300
              ),
              Text("Això és un gat")
            ],),
          Row(children: [
            Text("Això és un gos"),
            Image.network(
              'https://cdni.rt.com/actualidad/public_images/2019.04/article/5ca865b308f3d9f63a8b4567.jpg',
              width: 300,
              height: 300
            )
          ],)
        ],)        
      ),
    );
  }
}

// Image.network(
//             'https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/article/600033325bafe872e9c3bf12/gatito_0.jpg',
//             width: 300,
//             height: 300
//           )