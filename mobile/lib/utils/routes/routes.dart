import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:mobile/ui/screens/auth/login.dart';
import 'package:mobile/ui/screens/auth/signup/signup.dart';
import 'package:mobile/utils/routes/route_const.dart';
import '../../ui/screens/home/home.dart';

class AppRouter {
  static GoRouter router = GoRouter(
    routes: [
      GoRoute(
        path: "/",
        name: RouteConstants.home,
        pageBuilder: (context, state) =>
            const MaterialPage(child: HomeScreen()),
        redirect: (context, state) async {
          bool authenticated = false;
          if (authenticated == false) {
            return state.namedLocation(RouteConstants.signup);
          } else {
            return null;
          }
        },
      ),
      GoRoute(
          path: "/login",
          name: RouteConstants.login,
          pageBuilder: (context, state) =>
              const MaterialPage(child: LoginScreen())),
      GoRoute(
          path: "/signup",
          name: RouteConstants.signup,
          pageBuilder: (context, state) =>
              const MaterialPage(child: SignUpScreen())),
    ],
  );
}
