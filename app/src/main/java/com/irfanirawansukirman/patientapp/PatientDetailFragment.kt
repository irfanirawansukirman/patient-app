package com.irfanirawansukirman.patientapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.irfanirawansukirman.patientapp.PatientListFragment.Companion.PATIENT_AGE
import com.irfanirawansukirman.patientapp.PatientListFragment.Companion.PATIENT_DATE_OF_BIRTH
import com.irfanirawansukirman.patientapp.PatientListFragment.Companion.PATIENT_HISTORY
import com.irfanirawansukirman.patientapp.PatientListFragment.Companion.PATIENT_IMAGE
import com.irfanirawansukirman.patientapp.PatientListFragment.Companion.PATIENT_NAME
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.patient_detail_fragment.*

class PatientDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.patient_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPatientData()
    }

    private fun setupPatientData() {
        arguments?.let {
            txtPatientDetailName.text = it.getString(PATIENT_NAME)
            txtPatientDetailAge.text = it.getString(PATIENT_AGE)
            txtPatientDetailDateOfBirth.text = it.getString(PATIENT_DATE_OF_BIRTH)
            txtPatientDetailHistory.text = it.getString(PATIENT_HISTORY)
            Picasso.get().load(it.getString(PATIENT_IMAGE)).into(imgPatientDetail)
        }
    }
}