package com.irfanirawansukirman.patientapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.patient_item.view.*

class PatientAdapter(private val patientList: List<Patient>,
                     private val patientItemListener: PatientItemListener) :
    RecyclerView.Adapter<PatientAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.patient_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = patientList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindItem(patientList[position], patientItemListener)
    }

    class ItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(patient: Patient, patientItemListener: PatientItemListener) {
            view.apply {
                patient.run {
                    Picasso.get().load(imageUrl).into(imgPatient)
                    txtPatientName.text = name
                    txtPatientAge.text = age
                    txtPatientDateOfBirth.text = dateOfBirth
                    txtPatientHistory.text = history
                    linPatientContainer.setOnClickListener {
                        patientItemListener.onPatientSelected(patient)
                    }
                }
            }
        }
    }
}