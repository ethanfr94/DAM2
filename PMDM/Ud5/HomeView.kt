
@Composable
fun HomeView() {
	
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Reproducción con Media Player",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {  },
        ) {
            Text("Archivo en Raw")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {}, ) {
            Text("Archivo en Descargas")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {}, ) {
            Text("URL de Archivo")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("URL") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { },
        ) {
            Text("Pausar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
            },
        ) {
            Text("Reanudar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {},
           
        ) {
            Text("Parar")
        }
    }
}