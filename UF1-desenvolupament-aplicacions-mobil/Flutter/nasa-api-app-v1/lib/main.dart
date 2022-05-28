import 'package:flutter/material.dart';
// import 'package:project/widgets/title_style.dart';
//void main() => runApp(const MyApp());

void main() {
  runApp(const MaterialApp(
    title: 'Navigation Basics',
    home: MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    var title = 'App per fer proves';
    return MaterialApp(
      title: title,
      home: Scaffold(
          backgroundColor: Colors.grey[300],
          appBar: AppBar(title: Text("Aplicació")),
          body: SingleChildScrollView(
            child: Stack(
              children: [
                Container( // Degradado
                  decoration: const BoxDecoration(
                      gradient: LinearGradient(
                          colors: <Color>[Colors.blueAccent, Colors.red])),
                  width: double.infinity,
                  height: 250,
                  child: Image.asset("assets/imatges/moon.png", scale: 5),
                ),
                Card(
                  color: Colors.white,
                  shadowColor: Colors.blueGrey,
                  margin: const EdgeInsets.only(left: 25, right: 25, top: 200),
                  child: Padding(
                    padding: const EdgeInsets.symmetric(
                        horizontal: 35, vertical: 50),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.start,
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        const Padding(
                          padding: EdgeInsets.only(bottom: 10),
                          child: Text(
                            "LOGIN",
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                              color: Colors.black,
                            ),
                          ),
                        ),
                        TextFormField(
                          decoration:
                              const InputDecoration(labelText: "Usuari"),
                        ),
                        TextFormField(
                          decoration:
                              const InputDecoration(labelText: "Contrasenya"),
                          obscureText: true,
                        ),
                        Padding(
                          padding: const EdgeInsets.only(top: 20),
                          child: ElevatedButton(
                                child: const Text('Go in ->'),
                                onPressed: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                        builder: (context) => const DetailPage()),
                                  );
                                },
                            ),
                          
                        ),
                      ],
                    ),
                  ),
                ),
              ],
            ),
          )),
    );
  }
}

class DetailPage extends StatelessWidget {
  const DetailPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var title = 'App per fer proves';
    var size = MediaQuery.of(context).size;
    return MaterialApp(
      title: title,
      home: Scaffold(
        body: SingleChildScrollView(
          child: Stack(children: [
            Container(
              decoration: 
                const BoxDecoration(
                  image: DecorationImage(
                    image: NetworkImage("https://apod.nasa.gov/apod/image/2202/Chamaeleon_RobertEder1024.jpg"),
                    fit:  BoxFit.cover)
                ),
              width: double.infinity,
              height: size.height * 0.55,
            ),
            Container(
              margin: EdgeInsets.only(top: 250),
              width: double.infinity,
              height: size.height * 0.45,
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(50),
              ),
              child: Padding(
                padding: const EdgeInsets.all(40),
                child: Column(children: [
                  Row(children: [
                    const Text("Chamaeleon I Molecular Cloud", style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold
                    )),
                  ]
                  ,)
                ],),
              ),
            )
          ]),
        ),
      ),
    );
  }
}
