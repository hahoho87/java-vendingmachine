package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ChangesModuleTest {


    @Test
    @DisplayName("잔돈 모듈 생성")
    void createVendingMachine() {
        ChangesModule changesModule = new ChangesModule();
        assertThat(changesModule).isNotNull();
    }

    @ParameterizedTest(name = "잔돈 모듈에 {0} 원을 넣으면 {0}원이 들어있음을 알 수 있다")
    @ValueSource(ints = {500, 1000})
    @DisplayName("잔돈 모듈에 n원을 넣으면 n원이 들어있음을 알 수 있다")
    void returnXWhenInputX(int changes) {
        ChangesModule changesModule = new ChangesModule();
        changesModule.put(changes);
        assertThat(changesModule.getChanges()).isEqualTo(changes);
    }

    @Test
    @DisplayName("1000원이 들어있는 잔돈 모듈에 500원을 넣으면 500원이 들어있는 것을 알 수 있다")
    void return500WhenPut500InVendingMachineWith1000() {
        ChangesModule changesModule = new ChangesModule(1000);
        int inputMoney = 500;
        changesModule.put(inputMoney);
        assertThat(changesModule.getChanges()).isEqualTo(1500);
    }

    @Test
    @DisplayName("500원이 들어있는 잔돈 모듈에서 500원을 차감하면 0원이 남는다")
    void return0WhenWithdraw50OnVendingMachineWith1000() {
        ChangesModule changesModule = new ChangesModule(500);
        changesModule.withdraw(500);
        assertThat(changesModule.getChanges()).isZero();
    }

    @Test
    @DisplayName("1000원이 들어있는 잔돈 모듈에서 500원을 차감하면 500원이 남는다")
    void return500WhenWithdraw50OnVendingMachineWith1000() {
        ChangesModule changesModule = new ChangesModule(1000);
        changesModule.withdraw(500);
        assertThat(changesModule.getChanges()).isEqualTo(500);
    }

    @Test
    @DisplayName("0원이 들어있는 잔돈 모듈에서 500원을 차감할 수 없다")
    void cannotWithDraw500OnVendingMachineWith1000() {
        ChangesModule changesModule = new ChangesModule(0);
        Throwable throwable = catchThrowable(() -> changesModule.withdraw(500));
        assertThat(throwable).isInstanceOf(IllegalStateException.class);
    }
}