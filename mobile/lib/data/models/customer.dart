class Customer {
  String userId;
  String firstName;
  String lastName;
  String birthDate;
  String cityOfBirth;
  String nicId;
  int phoneNumber;
  String email;
  String profilePicture;
  String password;
  String pin;

  Customer({
    required this.userId,
    required this.firstName,
    required this.lastName,
    required this.birthDate,
    required this.cityOfBirth,
    required this.nicId,
    required this.phoneNumber,
    required this.email,
    required this.profilePicture,
    required this.password,
    required this.pin,
  });

  factory Customer.fromJson(Map<String, dynamic> json) {
    return Customer(
      userId: json['userId'],
      firstName: json['firstName'],
      lastName: json['lastName'],
      birthDate: json['birthDate'],
      cityOfBirth: json['cityOfBirth'],
      nicId: json['nicId'],
      phoneNumber: json['phoneNumber'],
      email: json['email'],
      profilePicture: json['profilePicture'],
      password: json['password'],
      pin: json['pin'],
    );
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['firstName'] = firstName;
    data['lastName'] = lastName;
    data['birthDate'] = birthDate;
    data['cityOfBirth'] = cityOfBirth;
    data['nicId'] = nicId;
    data['phoneNumber'] = phoneNumber;
    data['email'] = email;
    data['profilePicture'] = profilePicture;
    data['password'] = password;
    data['pin'] = pin;
    return data;
  }
}
