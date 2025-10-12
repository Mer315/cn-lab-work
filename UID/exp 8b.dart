import 'package:flutter/material.dart';

void main() => runApp(DifferentAnimationsApp());

class DifferentAnimationsApp extends StatefulWidget {
  @override
  _DifferentAnimationsAppState createState() => _DifferentAnimationsAppState();
}

class _DifferentAnimationsAppState extends State<DifferentAnimationsApp>
    with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _fadeAnimation;
  late Animation<Offset> _slideAnimation;
  late Animation<double> _scaleAnimation;
  late Animation<double> _rotationAnimation;

  @override
  void initState() {
    super.initState();

    // Animation Controller
    _controller = AnimationController(
      duration: const Duration(seconds: 3),
      vsync: this,
    )..repeat(reverse: true);

    // Fade Animation (opacity 0 -> 1)
    _fadeAnimation = Tween<double>(begin: 0.0, end: 1.0).animate(_controller);

    // Slide Animation (moves from left to right)
    _slideAnimation =
        Tween<Offset>(begin: const Offset(-1, 0), end: const Offset(0, 0))
            .animate(_controller);

    // Scale Animation (0.5x -> 1.5x)
    _scaleAnimation = Tween<double>(begin: 0.5, end: 1.5).animate(
      CurvedAnimation(parent: _controller, curve: Curves.easeInOut),
    );

    // Rotation Animation (0° -> 360°)
    _rotationAnimation =
        Tween<double>(begin: 0.0, end: 1.0).animate(_controller);
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        backgroundColor: Colors.grey[900],
        appBar: AppBar(
          title: const Text("Experiment with Animations"),
          centerTitle: true,
          backgroundColor: Colors.teal,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              // Fade Animation
              FadeTransition(
                opacity: _fadeAnimation,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.orange,
                  child: const Center(
                    child: Text(
                      "Fade",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ),

              // Slide Animation
              SlideTransition(
                position: _slideAnimation,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.green,
                  child: const Center(
                    child: Text(
                      "Slide",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ),

              // Scale Animation
              ScaleTransition(
                scale: _scaleAnimation,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.purple,
                  child: const Center(
                    child: Text(
                      "Scale",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ),

              // Rotation Animation
              RotationTransition(
                turns: _rotationAnimation,
                child: Container(
                  width: 100,
                  height: 100,
                  color: Colors.blue,
                  child: const Center(
                    child: Text(
                      "Rotate",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
