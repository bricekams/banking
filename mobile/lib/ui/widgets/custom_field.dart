import 'package:flutter/material.dart';

class CustomField extends StatelessWidget {
  final Widget? suffixIcon;
  final Widget? prefixIcon;
  final String? hintText;
  final Widget? label;
  const CustomField({Key? key, this.suffixIcon, this.prefixIcon, this.hintText,this.label}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      style: const TextStyle(
        fontWeight: FontWeight.w500,
      ),
      decoration: InputDecoration(
        label: label,
        hintText: hintText,
        hintStyle:  const TextStyle(
          fontWeight: FontWeight.w500,
        ),
        suffixIcon: suffixIcon,
        prefixIcon: prefixIcon,
        focusedBorder: OutlineInputBorder(
            borderSide: const BorderSide(width: 2),
            borderRadius: BorderRadius.circular(5)),
        enabledBorder: OutlineInputBorder(
          borderSide:
          BorderSide(width: 2, color: Colors.grey.shade600),
          borderRadius: BorderRadius.circular(5),
        ),
        errorBorder: OutlineInputBorder(
          borderSide: BorderSide(width: 2,color: Theme.of(context).colorScheme.error),
          borderRadius: BorderRadius.circular(5),
        ),
        focusedErrorBorder: OutlineInputBorder(
          borderSide: BorderSide(width: 2,color: Theme.of(context).colorScheme.error),
          borderRadius: BorderRadius.circular(5),
        ),
      ),
    );
  }
}
