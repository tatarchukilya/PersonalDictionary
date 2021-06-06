package ru.tatarchuk.personaldictionary.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.core.DIFragment
import ru.tatarchuk.personaldictionary.presentation.viewmodel.SendNewWordViewModel

/**
 * @author tatarchukilya@gmail.com
 */
class SendNewWordFragment : DIFragment() {

    private lateinit var viewModel: SendNewWordViewModel

    private lateinit var send: Button

    private var word: String = ""
        set(value) {
            field = value
            setSendButtonVisibility()
        }
    private var transcription: String = ""
        set(value) {
            field = value
            setSendButtonVisibility()
        }
    private var translation: String = ""
        set(value) {
            field = value
         //   setSendButtonVisibility()
        }
    private var example: String = ""
        set(value) {
            field = value
       //     setSendButtonVisibility()
        }

    override fun layoutResId() = R.layout.fragment_send_new_word

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(
                requireActivity(),
                viewModelApi.getSendNewWordViewModelFactory()
            ).get(SendNewWordViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        send = view.findViewById(R.id.send)
        send.isEnabled = true
        send.setOnClickListener {
            viewModel.addWord(word, transcription, translation, example)
        }
        view.findViewById<EditText>(R.id.transcription).doAfterTextChanged {
            it?.let {
                transcription = it.toString()
            }
        }
        view.findViewById<EditText>(R.id.word).doAfterTextChanged {
            it?.let {
                word = it.toString()
            }
        }
        view.findViewById<EditText>(R.id.translation).doAfterTextChanged {
            it?.let {
                translation = it.toString()
            }
        }
        view.findViewById<EditText>(R.id.example).doAfterTextChanged {
            it?.let {
                example = it.toString()
            }
        }
    }

    private fun setSendButtonVisibility() {
        send.isEnabled = word.isNotBlank() && transcription.isNotBlank() //&& translation.isNotBlank()
    }

    companion object {

        fun newInstance(): SendNewWordFragment {
            return SendNewWordFragment()
        }
    }
}