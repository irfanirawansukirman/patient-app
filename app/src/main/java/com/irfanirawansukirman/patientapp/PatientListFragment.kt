package com.irfanirawansukirman.patientapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.patient_fragment.*

data class Patient(
    val name: String,
    val age: String,
    val dateOfBirth: String,
    val history: String,
    val imageUrl: String
)

interface PatientItemListener {
    fun onPatientSelected(patient: Patient)
}

class PatientListFragment : Fragment(), PatientItemListener {

    override fun onPatientSelected(patient: Patient) {
        patient.run {
            val bundle = bundleOf(
                PATIENT_NAME to name,
                PATIENT_AGE to age,
                PATIENT_DATE_OF_BIRTH to dateOfBirth,
                PATIENT_HISTORY to history,
                PATIENT_IMAGE to imageUrl
            )
            findNavController().navigate(R.id.patientDetail, bundle)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.patient_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPatientList()
    }

    private fun setupPatientList() {
        recyclerPatient.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PatientAdapter(getPatientList(), this@PatientListFragment)
        }
    }

    private fun getPatientList() = mutableListOf<Patient>().apply {
        var index = 0
        while (index < 30) {
            add(
                Patient(
                    "Iskandar",
                    "32 tahun",
                    "Bandung, 11/12/13",
                    "Demam dan muntaber",
                    "https://i.gzn.jp/img/2019/08/23/android-10/00.png"
                )
            )
            index++
        }
    }

    companion object {
        const val PATIENT_NAME = "PATIENT_NAME"
        const val PATIENT_AGE = "PATIENT_AGE"
        const val PATIENT_DATE_OF_BIRTH = "PATIENT_DATE_OF_BIRTH"
        const val PATIENT_HISTORY = "PATIENT_HISTORY"
        const val PATIENT_IMAGE = "PATIENT_IMAGE"
    }

}