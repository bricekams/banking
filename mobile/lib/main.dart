import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:mobile/ui/theme/theme.dart';
import 'package:mobile/utils/locale/locale.dart' as local;
import 'package:mobile/utils/routes/routes.dart';

import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      debugShowCheckedModeBanner: false,
      title: 'SBC',
      supportedLocales: local.supportedLocales,
      theme: AppTheme.light,
      routeInformationParser: AppRouter.router.routeInformationParser,
      routerDelegate:  AppRouter.router.routerDelegate,
    );
  }
}
