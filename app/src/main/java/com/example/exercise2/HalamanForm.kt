package com.example.exercise2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
) {
    var namaTxt by remember {
        mutableStateOf("")
    }
    var nimtTxt by remember {
        mutableStateOf("")
    }
    var konsenTxt by remember {
        mutableStateOf("")
    }
    var judulTxt by remember {
        mutableStateOf("")
    }
    var listData: MutableList<String> = mutableListOf(namaTxt,nimtTxt,konsenTxt,judulTxt)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        OutlinedTextField(
            value = namaTxt,
            onValueChange = {
                namaTxt = it
            },
            label = { Text(text = stringResource(id = R.string.nama)) }
        )

        OutlinedTextField(
            value = nimtTxt,
            onValueChange = {
                nimtTxt = it
            },
            label = { Text(text = stringResource(id = R.string.nim)) }
        )
        OutlinedTextField(
            value = konsenTxt,
            onValueChange = {
                konsenTxt = it
            },
            label = { Text(text = stringResource(id = R.string.konsen)) }
        )
        
        Spacer(modifier = Modifier.height(5.dp))


        Button(onClick = {onSubmitButtonClicked(listData)}) {
            Text(text = stringResource(id = R.string.btn_submit))
        }

    }

}

@Composable
fun SelectJK(
    option: List<String>,
    onSelectionChange: (String) ->Unit = {}
) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = "Dosen Pembimbing 1 " )
    }
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Row (modifier = Modifier.padding(16.dp)) {
        option.forEach { item ->
            Row (
                modifier = Modifier.selectable(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChange(item)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){

            }
        }
    }
}