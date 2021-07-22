package com.uninet.ufresh.bottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.uninet.ufresh.R


class BottomSheetFilterFragment : BottomSheetDialogFragment() {
    lateinit var autoCompleteTextView : AutoCompleteTextView
    var kategori_option = arrayOf<String>("daging","ikan","sayur","buah","bumbu")
    lateinit var arrayAdapter : ArrayAdapter<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_bottom_sheet_filter, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        arrayAdapter = ArrayAdapter<String>(requireActivity(),R.layout.option_kategori,kategori_option)

        autoCompleteTextView = view.findViewById(R.id.filter__category)
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString())
        autoCompleteTextView.setAdapter(arrayAdapter)
    }
}