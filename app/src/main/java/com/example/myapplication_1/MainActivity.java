package com.example.myapplication_1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication_1.Alerts.AlertFragment;
import com.example.myapplication_1.Alerts.PaymentChangeAlert;
import com.example.myapplication_1.Alerts.TariffsPickAlert;
import com.example.myapplication_1.Fragments.AddPointFragment;
import com.example.myapplication_1.Fragments.AddressFragment;
import com.example.myapplication_1.Fragments.AssistantFragment;
import com.example.myapplication_1.Fragments.Auth111Fragment;
import com.example.myapplication_1.Fragments.BlacklistPartnersFragment;
import com.example.myapplication_1.Fragments.BonusesFragment;
import com.example.myapplication_1.Fragments.ChatFragment;
import com.example.myapplication_1.Fragments.ChatSliderFragment;
import com.example.myapplication_1.Fragments.ChatWithOperator;
import com.example.myapplication_1.Fragments.CodeScreenFragment;
import com.example.myapplication_1.Fragments.CommentsFragment;
import com.example.myapplication_1.Fragments.CountryCodeSelectionFragment;
import com.example.myapplication_1.Fragments.CreateOrder115Fragment;
import com.example.myapplication_1.Fragments.DeployedMessagesFragment;
import com.example.myapplication_1.Fragments.DiagnosticsFragment;
import com.example.myapplication_1.Fragments.DriverChatFragment;
import com.example.myapplication_1.Fragments.DriverSpinnerFragment;
import com.example.myapplication_1.Fragments.EarningsFragment;
import com.example.myapplication_1.Fragments.EmptyChatWithDriverFragment;
import com.example.myapplication_1.Fragments.EnergyReductionFragment;
import com.example.myapplication_1.Fragments.ErrorOneFragment;
import com.example.myapplication_1.Fragments.ErrorTwoFragment;
import com.example.myapplication_1.Fragments.FreeOrders13ExpListFragment;
import com.example.myapplication_1.Fragments.HowToWorkFragment;
import com.example.myapplication_1.Fragments.InformationFragment;
import com.example.myapplication_1.Fragments.InformationPartnersFragment;
import com.example.myapplication_1.Fragments.MachinePurposeFragment;
import com.example.myapplication_1.Fragments.MachinePurposeLowerPartFragment;
import com.example.myapplication_1.Fragments.MachinePurposeOneFragment;
import com.example.myapplication_1.Fragments.Menu11Fragment;
import com.example.myapplication_1.Fragments.Menu162Fragment;
import com.example.myapplication_1.Fragments.MenuOneFragment;
import com.example.myapplication_1.Fragments.MenuTwoFragment;
import com.example.myapplication_1.Fragments.NewCardFragment;
import com.example.myapplication_1.Fragments.NewSearchFragment;
import com.example.myapplication_1.Fragments.Order115Fragment;
import com.example.myapplication_1.Fragments.OrderAcceptFragment;
import com.example.myapplication_1.Fragments.PartnersFragment;
import com.example.myapplication_1.Fragments.PaymentMethodFragment;
import com.example.myapplication_1.Fragments.PaymentPickFragment;
import com.example.myapplication_1.Fragments.ProgramErrorTwoFragment;
import com.example.myapplication_1.Fragments.RatingFragment;
import com.example.myapplication_1.Fragments.ReasonForRejectionFragment;
import com.example.myapplication_1.Fragments.RefusePaymentFragment;
import com.example.myapplication_1.Fragments.SearchCarFragment;
import com.example.myapplication_1.Fragments.SearchFragment;
import com.example.myapplication_1.Fragments.SeekbarFragment;
import com.example.myapplication_1.Fragments.SendTestFragment;
import com.example.myapplication_1.Fragments.ServiceFragment;
import com.example.myapplication_1.Fragments.SettingsFragment;
import com.example.myapplication_1.Fragments.SliderFragment;
import com.example.myapplication_1.Fragments.SpinnerFragment;
import com.example.myapplication_1.Fragments.SpinnerTariffsFragment;
import com.example.myapplication_1.Fragments.TariffsFragment;
import com.example.myapplication_1.Fragments.TravelStoryFragment;
import com.example.myapplication_1.Fragments.TravelStoryOneFragment;
import com.example.myapplication_1.Fragments.TripDetailsFragment;
import com.example.myapplication_1.Fragments.UserAgreementFragment;
import com.example.myapplication_1.Fragments.WishFragment;
import com.example.myapplication_1.Fragments.WriteFragment;
import com.example.myapplication_1.Other.PageMainFragment;
import com.example.myapplication_1.Other.SloppyDrivingExample;

//import com.example.myapplication_1.Fragments.ChatWithDriverFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        AddressFragment addressFragment = AddressFragment.getInstance(null);
        AddPointFragment addPointFragment = AddPointFragment.getInstance(null);
        AlertFragment alertFragment = AlertFragment.getInstance(null);
        AssistantFragment assistantFragment = AssistantFragment.getInstance(null);
        Auth111Fragment auth111Fragment = Auth111Fragment.getInstance(null);

        BlacklistPartnersFragment blacklistPartnersFragment = BlacklistPartnersFragment.getInstance(null);
        BonusesFragment bonusesFragment = BonusesFragment.getInstance(null);

        ChatFragment chatFragment = ChatFragment.getInstance(null);
//        ChatWithDriverFragment chatWithDriverFragment = ChatWithDriverFragment.getInstance(null);
        CodeScreenFragment codeScreenFragment = CodeScreenFragment.getInstance(null);
        CommentsFragment commentsFragment = CommentsFragment.getInstance(null);
        CountryCodeSelectionFragment countryCodeSelectionFragment = CountryCodeSelectionFragment.getInstance(null);
        CreateOrder115Fragment createOrder115Fragment = CreateOrder115Fragment.getInstance(null);
        ChatWithOperator chatWithOperator = ChatWithOperator.getInstance(null);
        ChatSliderFragment chatSliderFragment = ChatSliderFragment.getInstance(null);

        DeployedMessagesFragment deployedMessagesFragment = DeployedMessagesFragment.getInstance(null);
        DriverChatFragment driverChatFragment = DriverChatFragment.getInstance(null);
        DriverSpinnerFragment driverSpinnerFragment = DriverSpinnerFragment.getInstance(null);
        DiagnosticsFragment diagnosticsFragment = DiagnosticsFragment.getInstance(null);

        EarningsFragment earningsFragment = EarningsFragment.getInstance(null);
        EmptyChatWithDriverFragment emptyChatWithDriverFragment = EmptyChatWithDriverFragment.getInstance(null);
        EnergyReductionFragment energyReductionFragment = EnergyReductionFragment.getInstance(null);
        ErrorOneFragment errorOneFragment = ErrorOneFragment.getInstance(null);
        ErrorTwoFragment errorTwoFragment = ErrorTwoFragment.getInstance(null);

        FreeOrders13ExpListFragment freeOrders13ExpListFragment = FreeOrders13ExpListFragment.getInstance(null);

        HowToWorkFragment howToWorkFragment = HowToWorkFragment.getInstance(null);

        IsMoonTime isMoonTime = IsMoonTime.getInstance(null);
        InformationFragment informationFragment = InformationFragment.getInstance(null);
        InformationPartnersFragment informationPartnersFragment = InformationPartnersFragment.getInstance(null);

        MachinePurposeFragment machinePurposeFragment = MachinePurposeFragment.getInstance(null);
        MachinePurposeOneFragment machinePurposeOneFragment = MachinePurposeOneFragment.getInstance(null);
        MachinePurposeLowerPartFragment machinePurposeLowerPartFragment = MachinePurposeLowerPartFragment.getInstance(null);
        Menu11Fragment menu11Fragment = Menu11Fragment.getInstance(null);
        Menu162Fragment menu162Fragment = Menu162Fragment.getInstance(null);
        MenuOneFragment menuOneFragment = MenuOneFragment.getInstance(null);
        MenuTwoFragment menuTwoFragment = MenuTwoFragment.getInstance(null);

        NewCardFragment newCardFragment = NewCardFragment.getInstance(null);
        NewSearchFragment newSearchFragment = NewSearchFragment.getInstance(null);

        OrderAcceptFragment orderAcceptFragment = OrderAcceptFragment.getInstance(null);
        Order115Fragment order115Fragment = Order115Fragment.getInstance(null);

        PageMainFragment pageMainFragment = new PageMainFragment().getInstance(null);
        PartnersFragment partnersFragment = PartnersFragment.getInstance(null);
        PaymentChangeAlert paymentChangeAlert = PaymentChangeAlert.getInstance(null);
        PaymentMethodFragment paymentMethodFragment = PaymentMethodFragment.getInstance(null);
        PaymentPickFragment paymentPickFragment = PaymentPickFragment.getInstance(null);
        ProgramErrorTwoFragment programErrorTwoFragment = ProgramErrorTwoFragment.getInstance(null);

        RatingFragment ratingFragment = RatingFragment.getInstance(null);
        ReasonForRejectionFragment reasonForRejectionFragment = ReasonForRejectionFragment.getInstance(null);
        RefusePaymentFragment refusePaymentFragment = RefusePaymentFragment.getInstance(null);

        SearchCarFragment searchCarFragment = SearchCarFragment.getInstance(null);
        SearchFragment searchFragment = SearchFragment.getInstance(null);
        SeekbarFragment seekbarFragment = SeekbarFragment.getInstance(null);
        ServiceFragment serviceFragment = ServiceFragment.getInstance(null);
        SettingsFragment settingsFragment = SettingsFragment.getInstance(null);
        SpinnerFragment spinnerFragment = SpinnerFragment.getInstance(null);
        SliderFragment sliderFragment = SliderFragment.getInstance(null);
        SendTestFragment sendTestFragment = SendTestFragment.getInstance();
        SpinnerTariffsFragment spinnerTariffsFragment = SpinnerTariffsFragment.getInstance(null);
        SloppyDrivingExample sloppyDrivingExample = SloppyDrivingExample.getInstance(null);

        TariffsFragment tariffsFragment = TariffsFragment.getInstance(null);
        TravelStoryFragment travelStoryFragment = TravelStoryFragment.getInstance(null);
        TravelStoryOneFragment travelStoryOneFragment = TravelStoryOneFragment.getInstance(null);
        TariffsPickAlert tariffsPickAlert = TariffsPickAlert.getInstance(null);
        TripDetailsFragment tripDetailsFragment = TripDetailsFragment.getInstance(null);

        UserAgreementFragment userAgreementFragment = UserAgreementFragment.getInstance(null);

        WishFragment wishFragment = WishFragment.getInstance(null);
        WriteFragment writeFragment = WriteFragment.getInstance(null);


        getSupportFragmentManager().beginTransaction().add(R.id.rl_main, bonusesFragment, BonusesFragment.TAG).commit();
    }
}