import 'package:flutter/material.dart';

void main() => runApp(AnimatedApp());

class AnimatedApp extends StatefulWidget {
  @override
  _AnimatedAppState createState() => _AnimatedAppState();
}

class _AnimatedAppState extends State<AnimatedApp>
    with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _animation;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      duration: const Duration(seconds: 2),
      vsync: this,
    )..repeat(reverse: true);

    _animation = Tween<double>(begin: 0.5, end: 1.5).animate(_controller);
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: ScaleTransition(
            scale: _animation,
            child: const FlutterLogo(size: 100),
          ),
        ),
      ),
    );
  }
}

