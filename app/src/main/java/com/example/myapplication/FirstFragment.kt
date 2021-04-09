package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.myapplication.data.Todo
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private  lateinit var todo: Todo
    private  lateinit var  titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) { //фрагмент использует объект Bundle для
        // сохранения и загрузки состояния
        super.onCreate(savedInstanceState)
        todo = Todo()
    }

    override fun onStart() {
        super.onStart()

        titleField.addTextChangedListener(titleWatcher)

        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                todo.isSolved = isChecked
            }
        }
    }

//Именно в этой функции заполняется макет представления
//фрагмента, а заполненный объект View возвращается хост-
//activity.
    override fun onCreateView(
            inflater: LayoutInflater,// для заполнения макета
            container: ViewGroup?,//для заполнения макета
            savedInstanceState: Bundle?//Объект Bundle содержит данные, которые используются
        // функцией для воссоздания представления по сохраненному состоянию.
    ): View? {
        // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_first, container, false)

    titleField = view.findViewById(R.id.title_first) as EditText
    dateButton = view.findViewById(R.id.todo_date) as Button
    solvedCheckBox = view.findViewById(R.id.todo_solved) as CheckBox

    dateButton.apply {
        text=todo.data.toString()
        isEnabled = false
    }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }



    val titleWatcher = object: TextWatcher{

        override fun beforeTextChanged(
                s: CharSequence?,
                 start: Int,
                  count: Int,
                   after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(
                s: CharSequence?,
                  start: Int,
                   before: Int,
                     count: Int) {
                      todo.title.toString()
        }

        override fun afterTextChanged(s: Editable?) {
            TODO("Not yet implemented")
        }


    }


}

