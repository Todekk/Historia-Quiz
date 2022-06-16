package eu.todek.navigationtest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eu.todek.navigationtest.databinding.FragmentWrongAnswerBinding;

public class WrongAnswerFragment extends Fragment {

    private FragmentWrongAnswerBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWrongAnswerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tryAgainButton.setOnClickListener(v -> Navigation.findNavController(view).navigate(WrongAnswerFragmentDirections.actionWrongAnswerFragmentToQuestionFragment()));
    }
}