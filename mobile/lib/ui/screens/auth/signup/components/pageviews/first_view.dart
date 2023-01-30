import 'package:flutter/material.dart';
import 'package:mobile/ui/widgets/custom_field.dart';

GlobalKey<FormState> formKeyFirstView1 = GlobalKey<FormState>();
class FirstView extends StatelessWidget {
  const FirstView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    TextEditingController firstNameController = TextEditingController();
    TextEditingController lastNameController = TextEditingController();
    TextEditingController cityOfBirthController = TextEditingController();
    TextEditingController birthDateController = TextEditingController();

    String date = "";
    String label = "Birth Date";
    return Form(
      key: formKeyFirstView1,
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          const SizedBox(height: 3),
          CustomField(
            controller: firstNameController,
            textInputAction: TextInputAction.next,
            validator: (txt){
              if(txt==null || txt.isEmpty){
                return "Field required";
              }else{
                return null;
              }
            },
            label: const Text("First name"),
          ),
          const SizedBox(height: 20),
          CustomField(
            controller: lastNameController,
            textInputAction: TextInputAction.next,
            validator: (txt){
              if(txt==null || txt.isEmpty){
                return "Field required";
              }else{
                return null;
              }
            },
            label: const Text("Last name"),
          ),
          const SizedBox(height: 20),
          CustomField(
            controller: cityOfBirthController,
            textInputAction: TextInputAction.done,
            validator: (txt){
              if(txt==null || txt.isEmpty){
                return "Field required";
              }else{
                return null;
              }
            },
            label: const Text("City of birth"),
          ),
          const SizedBox(height: 20),
          StatefulBuilder(
            builder: (context,setState){
              return CustomField(
                controller: birthDateController,
                readOnly: true,
                onTapOutside: (pt){
                  FocusScope.of(context).unfocus();
                },
                label: Text(label),
                validator: (txt){
                  if(date.isEmpty){
                    return "field required";
                  }
                  return null;
                },
                suffixIcon: GestureDetector(
                  onTap: () {
                    showDatePicker(
                      context: context,
                      initialDate: DateTime(2005, 1, 1),
                      firstDate: DateTime(1850),
                      lastDate: DateTime.now().subtract(const Duration(days: 365*18)),
                    ).then((value){
                      if(value!=null){
                        setState((){
                          date = label = value.toLocal().toString().substring(0,10);
                          birthDateController.text = date;
                        });
                      }
                    });
                  },
                  child: const Icon(Icons.calendar_month_sharp),
                ),
              );
            },
          )
        ],
      ),
    );
  }
}
