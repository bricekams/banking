import 'package:flutter/material.dart';

GlobalKey<FormState> formKeyFourthView = GlobalKey<FormState>();

class FourthView extends StatelessWidget {
  const FourthView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Form(
      key: formKeyFourthView,
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [

        ],
      ),
    );
  }
}
