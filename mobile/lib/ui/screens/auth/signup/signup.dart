import 'dart:developer';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:mobile/ui/screens/auth/signup/components/pageviews/second_view.dart';
import 'package:mobile/ui/screens/auth/signup/components/pageviews/third_view.dart';
import 'package:mobile/ui/screens/auth/signup/components/pageviews/fourth_view.dart';

import '../../../../utils/routes/route_const.dart';
import 'components/pageviews/first_view.dart';

class SignUpScreen extends StatefulWidget {
  const SignUpScreen({Key? key}) : super(key: key);

  @override
  State<SignUpScreen> createState() => _SignUpScreenState();
}

class _SignUpScreenState extends State<SignUpScreen> {
  final PageController _pageController = PageController();
  int currentIndex = 0;
  bool verifyingOTP = false;
  bool otpAllFields = true;
  bool submitted = false;

  late int phoneNumber = int.parse(phoneNumberController.text);
  @override
  void initState() {
    super.initState();

    /// Attach a listener which will update the state and refresh the page index
    _pageController.addListener(() {
      if (_pageController.page?.round() != currentIndex) {
        setState(() {
          currentIndex = _pageController.page!.round();
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
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
                        "\$ENDEN",
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
                    "Create account",
                    style: GoogleFonts.alata(
                      fontWeight: FontWeight.bold,
                      fontSize: 35,
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.only(
                        right: MediaQuery.of(context).size.width / 7),
                    child: RichText(
                      text: TextSpan(
                        children: [
                          TextSpan(
                            text:
                                "Please, fill in the required information or read more about ",
                            style: GoogleFonts.alata(
                              fontWeight: FontWeight.bold,
                              fontSize: 15,
                              color: Colors.grey.shade800,
                            ),
                          ),
                          TextSpan(
                            text: "how do we collect and use your data",
                            style: GoogleFonts.alata(
                              fontWeight: FontWeight.bold,
                              fontSize: 15,
                              color: Colors.cyan,
                            ),
                          )
                        ],
                      ),
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 15),
              Expanded(
                flex: 10,
                child: PageView(
                  physics: const NeverScrollableScrollPhysics(),
                  controller: _pageController,
                  children: const [
                    FirstView(),
                    SecondView(),
                    ThirdView(),
                    FourthView()
                  ],
                ),
              ),
              const Spacer(
                flex: 1,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  currentIndex != 0
                      ? MaterialButton(
                          color: Theme.of(context).colorScheme.primary,
                          textTheme: ButtonTextTheme.primary,
                          padding: const EdgeInsets.symmetric(
                              horizontal: 10, vertical: 15),
                          onPressed: () {
                            switch (currentIndex){
                              case 3:
                                _pageController.animateToPage(currentIndex - 2,
                                    duration: const Duration(milliseconds: 400),
                                    curve: Curves.easeIn);
                                break;
                              default:
                                _pageController.animateToPage(currentIndex - 1,
                                    duration: const Duration(milliseconds: 400),
                                    curve: Curves.easeIn);
                                break;
                            }
                          },
                          child: Text(currentIndex == 2 ? "Cancel" : "Back"),
                        )
                      : TextButton(
                          onPressed: () {
                            context.pushNamed(RouteConstants.login);
                          },
                          child: Text(
                            "Already have account ?",
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.w900,
                              color: Colors.black,
                            ),
                          ),
                        ),
                  MaterialButton(
                    color: Theme.of(context).colorScheme.primary,
                    textTheme: ButtonTextTheme.primary,
                    padding: const EdgeInsets.symmetric(
                        horizontal: 10, vertical: 15),
                    onPressed: otpAllFields==false ? null : () {
                      switch (currentIndex) {
                        case 0:
                          if (formKeyFirstView.currentState!.validate()) {
                            _pageController.animateToPage(currentIndex + 1,
                                duration: const Duration(milliseconds: 400),
                                curve: Curves.easeIn);
                          }
                          break;
                        case 1:
                          if (formKeySecondView.currentState!.validate()) {
                            phoneNumber = int.parse(phoneNumberController.text);
                            FirebaseAuth auth = FirebaseAuth.instance;
                            auth.verifyPhoneNumber(
                              phoneNumber: "+237$phoneNumber",
                              codeSent: (String verificationId, int? resendToken) async {
                                log("code sent");
                                _pageController.jumpToPage(2);
                                do{

                                } while (submitted==false);

                                String otpSMS = "${otpInputController_1.text}${otpInputController_2.text}${otpInputController_3.text}${otpInputController_4.text}";
                                PhoneAuthCredential credential = PhoneAuthProvider.credential(verificationId: verificationId, smsCode: otpSMS);
                                auth.signInWithCredential(credential).then((value){
                                  verifyingOTP = false;
                                  setState(() {

                                  });
                                  if(value.user!=null){
                                    _pageController.animateToPage(currentIndex + 1,
                                        duration: const Duration(milliseconds: 400),
                                        curve: Curves.easeIn);
                                  }
                                });
                              },
                              verificationCompleted: (PhoneAuthCredential phoneAuthCredential) {  },
                              verificationFailed: (FirebaseAuthException error) {
                                log("${error.code}: ${error.message ?? ""}");
                              },
                              codeAutoRetrievalTimeout: (String verificationId) {  },
                            );
                          }
                          break;
                        case 2:
                          if (formKeyThirdView.currentState!.validate()) {
                            submitted = true;
                            verifyingOTP = true;
                            setState(() {

                            });
                          }
                          break;
                        default:
                          break;
                      }
                    },
                    child: verifyingOTP
                        ? SizedBox(
                            height: 14,
                            width: 14,
                            child: CircularProgressIndicator(
                              color: Theme.of(context).colorScheme.onPrimary,
                            ),
                          )
                        : Text(currentIndex == 2 ? "Verify" : "Next"),
                  )
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}
