import 'dart:ui';

import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:intl_phone_field/intl_phone_field.dart';
import 'package:mobile/ui/widgets/custom_field.dart';

import '../../../utils/routes/route_const.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;

    TextEditingController phoneNumberController = TextEditingController();
    TextEditingController emailController = TextEditingController();
    TextEditingController passwordController = TextEditingController();

    GestureRecognizer recognizer = TapGestureRecognizer();

    return Scaffold(
      resizeToAvoidBottomInset: false,
      appBar: AppBar(
        backgroundColor: Colors.black,
        toolbarHeight: 0,
      ),
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Text(
                        "MAP\$",
                        style: GoogleFonts.abrilFatface(fontSize: 40),
                      ),
                      const SizedBox(width: 10),
                      const Expanded(
                        child: Divider(
                          thickness: 3,
                          color: Colors.black,
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 20),
                  Text(
                    "Welcome back",
                    style: GoogleFonts.alata(
                      fontWeight: FontWeight.bold,
                      fontSize: 35,
                    ),
                  ),
                  const SizedBox(height: 20),
                  Padding(
                    padding: EdgeInsets.only(
                        right: MediaQuery.of(context).size.width / 7),
                    child: Text(
                      "Please enter your phone number, we will send you a 5 digits code to verify your identity.",
                      style: GoogleFonts.alata(
                        fontWeight: FontWeight.bold,
                        fontSize: 15,
                        color: Colors.grey.shade800,
                      ),
                    ),
                  ),
                  const SizedBox(height: 30),
                  IntlPhoneField(
                    initialCountryCode: "CM",
                    dropdownTextStyle: const TextStyle(
                      fontWeight: FontWeight.w500
                    ),
                    style: const TextStyle(
                        fontWeight: FontWeight.w500
                    ),
                    cursorColor: Colors.grey.shade500,
                    decoration: InputDecoration(
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
                  ),
                  const SizedBox(height: 30),
                  RichText(
                    text: TextSpan(
                        style: GoogleFonts.roboto(
                            fontWeight: FontWeight.w600, color: Colors.black,
                        ),
                        children: [
                          const TextSpan(
                            text: "Don't have an account? ",
                          ),
                          TextSpan(
                              text: "register.",
                              recognizer: TapGestureRecognizer()..onTap = () {
                                context.pushNamed(RouteConstants.signup);
                              },
                              style: const TextStyle(
                                  color: Colors.cyan,
                                  fontWeight: FontWeight.bold))
                        ]),
                  ),
                ],
              ),
              const Spacer(),
              MaterialButton(
                color: Theme.of(context).colorScheme.primary,
                textTheme: ButtonTextTheme.primary,
                padding:
                    const EdgeInsets.symmetric(horizontal: 60, vertical: 15),
                onPressed: () {},
                child: const Text("Verify"),
              )
            ],
          ),
        ),
      ),
    );
  }
}
