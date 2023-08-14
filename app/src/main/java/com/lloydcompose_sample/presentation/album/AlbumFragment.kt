package com.lloydcompose_sample.presentation.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lloydcompose_sample.presentation.components.AlbumScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumFragment : Fragment() {

    private lateinit var composeView: ComposeView
    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            composeView = this
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        composeView.setContent {
            AlbumScreen(
                viewModel = viewModel,
                onItemClick = { title ->
                    val action =
                        AlbumFragmentDirections.actionAlbumFragmentToAlbumDetailsFragment(title)
                    findNavController().navigate(action)
                })
        }
    }

}