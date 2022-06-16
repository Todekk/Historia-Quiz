package eu.todek.navigationtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.util.List;

import eu.todek.navigationtest.databinding.FragmentCorrectAnswerBinding;


public class CorrectAnswerFragment extends Fragment {
    private FragmentCorrectAnswerBinding binding;
    private UserViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCorrectAnswerBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment

        model = new ViewModelProvider(this).get(UserViewModel.class);
        binding.addButton.setOnClickListener(v ->{
            User user = new User(binding.firstNameText.getText().toString(), binding.lastNameText.getText().toString(), binding.correctAnswerAmount.getText().toString());
            model.insert(user);
        });
        model.getUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                StringBuilder builder = new StringBuilder();

                for (User user : users){
                    builder.append("User: ");
                    builder.append(user.getUid());
                    builder.append(". ");
                    builder.append(user.getFirstName());
                    builder.append(" ");
                    builder.append(user.getLastName());
                    builder.append(" Score:");
                    builder.append(user.getScore());
                    builder.append("/5");
                    builder.append("\n");
                }

                String usersString = builder.toString();

                binding.resultText.setText(usersString);
            }
        });
        return binding.getRoot();



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int n = CorrectAnswerFragmentArgs.fromBundle(getArguments()).getNCorrectAnswers();
        String cAA = Integer.toString(n);
        binding.playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(CorrectAnswerFragmentDirections.actionCorrectAnswerFragmentToQuestionFragment());
            }
        });
        binding.correctAnswerAmount.setText(cAA);
    }
}