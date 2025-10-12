import 'dart:convert' as convert;
import 'package:http/http.dart' as http;

void main() async {
  // API endpoint for users
  final url = Uri.https(
    'jsonplaceholder.typicode.com',
    '/users',
  );

  // Send GET request
  final response = await http.get(url);

  if (response.statusCode == 200) {
    // Decode JSON response
    final List users = convert.jsonDecode(response.body);

    print('===== Users List =====\n');

    // Loop through users and print details
    for (var user in users) {
      final id = user['id'];
      final name = user['name'];
      final phone = user['phone'];

      print('ID: $id');
      print('Name: $name');
      print('Contact: $phone');
      print('--------------------');
    }
  } else {
    print('Request failed with code: ${response.statusCode}.');
  }
}
