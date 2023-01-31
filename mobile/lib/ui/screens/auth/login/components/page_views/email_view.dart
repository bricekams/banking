import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:mobile/ui/widgets/custom_field.dart';
import 'package:mobile/utils/routes/route_const.dart';

GlobalKey<FormState> loginFormKey = GlobalKey<FormState>();
TextEditingController emailController = TextEditingController();
TextEditingController passwordController = TextEditingController();

class LoginWithEmailView extends StatelessWidget {
  const LoginWithEmailView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    bool passwordHidden = true;
    return Form(
      key: loginFormKey,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisSize: MainAxisSize.min,
        children: [
          CustomField(
            prefixIcon: const Icon(Icons.email),
            label: const Text("Email"),
            controller: emailController,
          ),
          StatefulBuilder(
            builder: (context, setState) {
              return CustomField(
                obscureText: passwordHidden,
                prefixIcon: const Icon(Icons.lock),
                suffixIcon: GestureDetector(
                  onTap: () {
                    setState(() {
                      passwordHidden = !passwordHidden;
                    });
                  },
                  child: Icon(
                      passwordHidden ? Icons.visibility : Icons.visibility_off),
                ),
                label: const Text("Password"),
                controller: passwordController,
              );
            },
          ),
          const SizedBox(height: 30),
          RichText(
            text: TextSpan(
                style: GoogleFonts.roboto(
                  fontWeight: FontWeight.w600,
                  color: Colors.black,
                ),
                children: [
                  TextSpan(
                      text: "I forgot my password.",
                      recognizer: TapGestureRecognizer()..onTap = () {
                        context.pushNamed(RouteConstants.recover);
                      },
                      style: const TextStyle(
                          color: Colors.cyan, fontWeight: FontWeight.bold))
                ]),
          )
        ],
      ),
    );
  }
}
