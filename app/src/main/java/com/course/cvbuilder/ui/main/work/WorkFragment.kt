package com.course.cvbuilder.ui.main.work

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.course.cvbuilder.R
import edu.miu.CVBuilderApp.data.Work


/**
 * A simple [Fragment] subclass.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFragment : Fragment(R.layout.fragment_work),OnAddWorkListner {
    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                Work(
                    "Pinterest",
                    "Software Development Engineer II",
                    "2022 - Present",
                    R.drawable.pinterest
                ),
                Work(
                    "MIU",
                    "Teaching Assistant",
                    "2022-2022",
                    R.drawable.miu
                ),
                Work(
                    "Alamein International University",
                    "Software Engineer & TA",
                    "2020 - 2021",
                    R.drawable.aiu
                ),
                Work(
                    "OpenAVN",
                    "Software Development Engineer I",
                    "2020 - 2021",
                    R.drawable.openavn
                ),
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
           val dialog = WorkDialog()
        dialog.setWorlListner(this)
            dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun addWork(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }
}