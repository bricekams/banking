import 'package:flutter/material.dart';
import 'package:mobile/ui/widgets/custom_field.dart';

class FirstView extends StatelessWidget {
  const FirstView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: const [
        CustomField(
          label: Text("First name"),
        ),
        SizedBox(height: 20),
        CustomField(
          label: Text("Last name"),
        ),
        SizedBox(height: 20),
        CustomField(
          label: Text("City of birth"),
        ),
        SizedBox(height: 20),
        CustomField()
      ],
    );
  }
}
