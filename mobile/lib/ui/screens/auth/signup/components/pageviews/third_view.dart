import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:mobile/ui/screens/auth/signup/widgets/otp_input.dart';


TextEditingController otpInputController_1 = TextEditingController();
TextEditingController otpInputController_2 = TextEditingController();
TextEditingController otpInputController_3 = TextEditingController();
TextEditingController otpInputController_4 = TextEditingController();
TextEditingController otpInputController_5 = TextEditingController();

GlobalKey<FormState> formKeyThirdView = GlobalKey<FormState>();

class ThirdView extends StatelessWidget {
  const ThirdView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Form(
      key: formKeyThirdView,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisSize: MainAxisSize.min,
        children: [
          Padding(
            padding:
                EdgeInsets.only(right: MediaQuery.of(context).size.width / 7),
            child: Text(
              "We've sent you a five digits code, please fill it to proceed.",
              style: GoogleFonts.alata(
                fontWeight: FontWeight.bold,
                fontSize: 15,
                color: Colors.grey.shade800,
              ),
            ),
          ),
          const SizedBox(height: 30),
          Row(
            children: [
              OTPInput(controller: otpInputController_1, index: 1),
              OTPInput(controller: otpInputController_2, index: 2),
              OTPInput(controller: otpInputController_3, index: 3),
              OTPInput(controller: otpInputController_4, index: 4),
            ],
          ),
          const SizedBox(height: 20),
          Text(
            "You'll be able to resend the code in 00:57",
            style: GoogleFonts.roboto(
              fontWeight: FontWeight.w600, color: Colors.black,
            ),
          ),

        ],
      ),
    );
  }
}
