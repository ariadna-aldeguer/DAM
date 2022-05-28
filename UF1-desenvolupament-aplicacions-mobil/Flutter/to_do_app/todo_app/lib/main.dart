import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  Widget build(BuildContext context) {
    var title = "To do App";
    var myTasks = "My Tasks";
    var todo = "To Do";
    var tasks1 = "5 tasks now. 1 started";
    var inprogress = "In Progress";
    var tasks2 = "1 tasks now. 1 started";
    var done = "Done";
    var tasks3 = "18 tasks now. 13 started";
    var activeprojects = "Active Projects";
    var medicalapp = "Medical App";
    var progress1 = "9 hours progress";
    var making = "Making History Notes";
    var sports = "Sports App";
    var online = "Online Flutter Course";
    return MaterialApp(
      title: title,
      home: Scaffold(
          backgroundColor: Color(0xfffff9ec),
          appBar: AppBar(
              title: Text(title),
              foregroundColor: Colors.black,
              backgroundColor: const Color(0xfff9be7c)),
          body: Padding(
            padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 20),
            child: Column(
              children: [
                Row(
                  children: [
                    // My Tasks
                    Text(myTasks,
                        style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 25,
                            fontFamily: 'Raleway'))
                  ],
                ),
                Container(
                  // To do
                  padding: const EdgeInsets.only(top: 20),
                  child: Row(
                    children: [
                      Column(
                        children: [
                          Container(
                            width: 50,
                            height: 50,
                            decoration: BoxDecoration(
                                color: const Color(0xffe46472),
                                borderRadius: BorderRadius.circular(50)),
                            child: const Icon(Icons.access_alarm,
                                color: Colors.white),
                          )
                        ],
                      ),
                      Padding(
                        padding: const EdgeInsets.only(left: 10),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Row(
                              children: [
                                Text(
                                  todo,
                                  style: const TextStyle(
                                      fontWeight: FontWeight.bold,
                                      fontSize: 18,
                                      fontFamily: 'Raleway'),
                                )
                              ],
                            ),
                            Row(
                              children: [
                                Text(tasks1,
                                    style: const TextStyle(
                                        color: Color(0xff9B9B9B),
                                        fontWeight: FontWeight.bold,
                                        fontSize: 14))
                              ],
                            )
                          ],
                        ),
                      )
                    ],
                  ),
                ),
                Container(
                  // In Progress
                  padding: const EdgeInsets.only(top: 20),
                  child: Row(
                    children: [
                      Column(
                        children: [
                          Container(
                            width: 50,
                            height: 50,
                            decoration: BoxDecoration(
                                color: const Color(0xfff9be7c),
                                borderRadius: BorderRadius.circular(50)),
                            child: const Icon(Icons.change_circle_outlined,
                                color: Colors.white),
                          )
                        ],
                      ),
                      Padding(
                        padding: const EdgeInsets.only(left: 10),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Row(
                              children: [
                                Text(
                                  inprogress,
                                  style: const TextStyle(
                                      fontWeight: FontWeight.bold,
                                      fontSize: 20,
                                      fontFamily: 'Raleway'),
                                )
                              ],
                            ),
                            Row(
                              children: [
                                Text(tasks2,
                                    style: const TextStyle(
                                        color: Color(0xff9B9B9B),
                                        fontWeight: FontWeight.bold))
                              ],
                            )
                          ],
                        ),
                      )
                    ],
                  ),
                ),
                Container(
                  // Done
                  padding: const EdgeInsets.only(top: 20),
                  child: Row(
                    children: [
                      Column(
                        children: [
                          Container(
                            width: 50,
                            height: 50,
                            decoration: BoxDecoration(
                                color: const Color(0xff6488e4),
                                borderRadius: BorderRadius.circular(50)),
                            child: const Icon(Icons.access_alarm,
                                color: Colors.white),
                          )
                        ],
                      ),
                      Padding(
                        padding: const EdgeInsets.only(left: 10),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Row(
                              children: [
                                Text(
                                  todo,
                                  style: const TextStyle(
                                      fontWeight: FontWeight.bold,
                                      fontSize: 20,
                                      fontFamily: 'Raleway'),
                                )
                              ],
                            ),
                            Row(
                              children: [
                                Text(tasks3,
                                    style: const TextStyle(
                                        color: Color(0xff9B9B9B),
                                        fontWeight: FontWeight.bold))
                              ],
                            )
                          ],
                        ),
                      )
                    ],
                  ),
                ),
                Container(
                  // Active Projects
                  padding: const EdgeInsets.symmetric(vertical: 10),
                  child: Row(
                    children: [
                      // My Tasks
                      Text(activeprojects,
                          style: const TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              fontFamily: 'Raleway'))
                    ],
                  ),
                ),
                Column(
                  children: [
                    // Dos primeros cuadritos
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        Padding( // Medical App
                          padding: const EdgeInsets.all(8.0),
                          child: 
                          Container( 
                              width: 110,
                              height: 130,
                              decoration: BoxDecoration(
                                  color: const Color(0xff487779),
                                  borderRadius: BorderRadius.circular(30)),
                              child: Padding(
                                padding: const EdgeInsets.all(10),
                                child: Column(
                                  mainAxisAlignment: MainAxisAlignment.start,
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Icon(
                                      Icons.circle_outlined,
                                      semanticLabel: "25%",
                                      size: 50,
                                      color: Colors.white,
                                    ),
                                    Padding(
                                      padding: EdgeInsets.only(top: 20),
                                      child: Column(
                                        mainAxisAlignment:
                                            MainAxisAlignment.start,
                                        crossAxisAlignment:
                                            CrossAxisAlignment.start,
                                        children: [
                                          Text(
                                            medicalapp,
                                            style: TextStyle(
                                                color: Colors.white,
                                                fontWeight: FontWeight.bold,
                                                fontSize: 12),
                                          ),
                                          Text(progress1,
                                              style: TextStyle(
                                                  color: Colors.white60,
                                                  fontSize: 10))
                                        ],
                                      ),
                                    )
                                  ],
                                ),
                              )),
                        ),
                        Container( // Making History Notes
                            width: 110,
                            height: 130,
                            decoration: BoxDecoration(
                                color: const Color(0xffe46472),
                                borderRadius: BorderRadius.circular(30)),
                            child: Padding(
                              padding: const EdgeInsets.all(10),
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.start,
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Icon(
                                    Icons.circle_outlined,
                                    semanticLabel: "25%",
                                    size: 50,
                                    color: Colors.white,
                                  ),
                                  Padding(
                                    padding: EdgeInsets.only(top: 20),
                                    child: Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.start,
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text(
                                          making,
                                          overflow: TextOverflow.clip,
                                          style: TextStyle(
                                              color: Colors.white,
                                              fontWeight: FontWeight.bold,
                                              fontSize: 12),
                                        ),
                                        Text(progress1,
                                            style: TextStyle(
                                                color: Colors.white60,
                                                fontSize: 10))
                                      ],
                                    ),
                                  )
                                ],
                              ),
                            ))
                      ],
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        Container(
                            width: 110,
                            height: 120,
                            decoration: BoxDecoration(
                                color: const Color(0xfff9be7c),
                                borderRadius: BorderRadius.circular(30)),
                            child: Padding(
                              padding: const EdgeInsets.all(10),
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.start,
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Icon(
                                    Icons.circle_outlined,
                                    semanticLabel: "25%",
                                    size: 50,
                                    color: Colors.white,
                                  ),
                                  Padding(
                                    padding: EdgeInsets.only(top: 20),
                                    child: Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.start,
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text(
                                          medicalapp,
                                          style: TextStyle(
                                              color: Colors.white,
                                              fontWeight: FontWeight.bold,
                                              fontSize: 12),
                                        ),
                                        Text(progress1,
                                            style: TextStyle(
                                                color: Colors.white60,
                                                fontSize: 10))
                                      ],
                                    ),
                                  )
                                ],
                              ),
                            )),
                        Container(
                            width: 110,
                            height: 120,
                            decoration: BoxDecoration(
                                color: const Color(0xfff9be7c),
                                borderRadius: BorderRadius.circular(30)),
                            child: Padding(
                              padding: const EdgeInsets.all(10),
                              child: Column(
                                mainAxisAlignment: MainAxisAlignment.start,
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Icon(
                                    Icons.circle_outlined,
                                    semanticLabel: "25%",
                                    size: 50,
                                    color: Colors.white,
                                  ),
                                  Padding(
                                    padding: EdgeInsets.only(top: 20),
                                    child: Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.start,
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text(
                                          medicalapp,
                                          style: TextStyle(
                                              color: Colors.white,
                                              fontWeight: FontWeight.bold,
                                              fontSize: 12),
                                        ),
                                        Text(progress1,
                                            style: TextStyle(
                                                color: Colors.white60,
                                                fontSize: 10))
                                      ],
                                    ),
                                  )
                                ],
                              ),
                            ))
                      ],
                    )
                  ],
                )
              ],
            ),
          )),
    );
  }
}
