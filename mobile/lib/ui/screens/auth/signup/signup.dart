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
                  const SizedBox(height: 30),
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
              const SizedBox(height: 20),
              Expanded(
                flex: 4,
                child: PageView(
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
                          onPressed: () {},
                          child: const Text("Back"),
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
                    onPressed: () {},
                    child: const Text("Next"),
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
