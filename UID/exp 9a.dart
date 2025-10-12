import 'dart:convert' as convert;
import 'package:http/http.dart' as http;

void main() async {
  // API endpoint for users
  final url = Uri.https(
    'jsonplaceholder.typicode.com',
    '/users',
  );

  // Fetch the data
  final response = await http.get(url);

  if (response.statusCode == 200) {
    final List json = convert.jsonDecode(response.body);

    // Loop through each user and print details
    for (var user in json) {
      final id = user['id'];
      final name = user['name'];
      final phone = user['phone'];
      print('ID: $id, Name: $name, Contact: $phone');
    }
  } else {
    print('Request failed with code: ${response.statusCode}.');
  }
}
