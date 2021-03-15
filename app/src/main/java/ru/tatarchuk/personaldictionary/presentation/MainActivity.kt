package ru.tatarchuk.personaldictionary.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.PermissionChecker
import com.google.firebase.firestore.FirebaseFirestore
import ru.tatarchuk.personaldictionary.R
import ru.tatarchuk.personaldictionary.presentation.fragment.DictionaryFragment
import ru.tatarchuk.personaldictionary.presentation.fragment.NewWordFragment
import ru.tatarchuk.personaldictionary.presentation.fragment.SingleWordFragment
import ru.tatarchuk.personaldictionary.presentation.fragment.TestFragment
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), MainRouter {

    val path = "/storage/emulated/0/Download/dictionary.txt"

    val dataString = "estate\t[ is'teit ]\tпоместье, имущество, сословие"

    private val PERMISSION_REQUEST_CODE = 123

    private var formatter = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())

    private val db = FirebaseFirestore.getInstance().collection("Words")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!hasPermissions())
            requestPerms()
        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, TestFragment())
                .commit()
        }
    }

//        if (!hasPermissions())
//            requestPerms()

//        findViewById<Button>(R.id.start).setOnClickListener {
//            db.whereEqualTo("word", "fly")
//                .get()
//                .addOnSuccessListener { querySnapshot ->
//                    var documentReference = querySnapshot.documents[0]
//                    //val value = documentReference.data
//                    documentReference.data?.forEach { data ->
//                        Log.i("<>", "${data.key} ${data.value}")
//                    }
//
////                    value?.let {
////                        documentReference.reference.set(it).addOnSuccessListener {
////                            Log.i("<>" ,"update ok")
////                        }.addOnFailureListener {
////                            Log.i("<>" ,"update failed")
////                        }
////                    }
//                }
//        }
//
//        findViewById<Button>(R.id.stop).setOnClickListener {
//            removeEqual("fly")
////            db.add(
////                hashMapOf(
////                    "word" to "pilot",
////                    "transcription" to "[ 'pailət ]",
////                    "translation" to "пилот"
////                )
////            )
////                .addOnSuccessListener {
////                    Log.i("<>", "Success")
////                }
////                .addOnFailureListener {
////                    Log.i("<>", "Failure")
////                }
//        }
//
//
//        //val words = db.collection("Words")
////        words.add(
////            mapOf(
////                "word" to "fly",
////                "transcription" to "[ flai ]",
////                "translate" to "летать, муха"
////            )
////        )

    private fun start() {

//        log("onRun, start")
//
//        scope.launch {
//            log("coroutine, start")
//            TimeUnit.MILLISECONDS.sleep(1000)
//            log("coroutine, end")
//        }
//
//        log("onRun, middle")
//
//        scope.launch {
//            log("coroutine2, start")
//            TimeUnit.MILLISECONDS.sleep(1500)
//            log("coroutine2, end")

//    }
//
//    log("onRun, end")
    }

    private fun stop() {

    }

    private fun log(text: String) {
        Log.d("TAG", "${formatter.format(Date())} $text [${Thread.currentThread().name}]")
    }

    private fun hasPermissions(): Boolean {
        var res = 0
        //string array of permissions,
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MANAGE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        for (perms in permissions) {
            res = PermissionChecker.checkCallingOrSelfPermission(this, perms)
            if (res != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun requestPerms() {
        val permissions = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MANAGE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(this, permissions, PERMISSION_REQUEST_CODE)
        }
    }

    private fun addIfEmpty(word: String) {
        Log.i("<>", "add $word")
        db
            .whereEqualTo("word", word)
            .get()
            .addOnSuccessListener { querySnapshot ->
                Log.i("<>", "addIfEmpty $word")
                var size = querySnapshot.size()
                if (size == 1) {
                    Log.i("<>", "full word $word size = $size")
                } else {
                    Log.i("<>", "empty word $word size = $size")
                }
            }
            .addOnFailureListener {
                Log.i("<>", "word $word failed", it)
            }
    }

    private fun removeEqual(word: String) {
        Log.i("<>", "removeEqual + $word")
        db
            .whereEqualTo("word", word)
            .get()
            .addOnSuccessListener { querySnapshot ->
                var size = querySnapshot.size()
                while (size > 1) {
                    Log.i("<>", "$word size = $size")
                    querySnapshot.documents[(size - 1)].reference.delete().addOnSuccessListener {
                        Log.i("<>", " $word deleted")
                    }
                    //TimeUnit.MILLISECONDS.sleep(500)
                    size--
                }
            }
            .addOnFailureListener {

            }
    }

    override fun showDetails(word: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, SingleWordFragment.newInstance(word))
            .addToBackStack(null)
            .commit()
    }

    override fun newWord() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, NewWordFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

//AIzaSyBY9rGVWi8EjNmhsvkBg71VfHQp59NNyHo
//https://translation.googleapis.com

// Одно слово
//https://translation.googleapis.com/language/translate/v2?target=en&source=ru&key=AIzaSyBY9rGVWi8EjNmhsvkBg71VfHQp59NNyHo&q=проба
// https://api.cognitive.microsofttranslator.com/languages?api-version=3.0
}
