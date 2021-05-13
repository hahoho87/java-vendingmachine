package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {


    @Test
    @DisplayName("자판기 생성")
    void createVendingMachine() {
        VendingMachine vendingMachine = new VendingMachine();
        assertThat(vendingMachine).isNotNull();
    }

    @ParameterizedTest(name = "자판기에 {0} 원을 넣으면 {0}원이 들어있음을 알 수 있다")
    @ValueSource(ints = {500, 1000})
    @DisplayName("자판기에 n원을 넣으면 n원이 들어있음을 알 수 있다")
    void returnXWhenInputX(int changes) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.put(changes);
        assertThat(vendingMachine.getChanges()).isEqualTo(changes);
    }

    @Test
    @DisplayName("1000원이 들어있는 자판기에 500원을 넣으면 500원이 들어있는 것을 알 수 있다")
    void return500WhenPut500InVendingMachineWith1000() {
        VendingMachine vendingMachine = new VendingMachine(1000);
        int inputMoney = 500;
        vendingMachine.put(inputMoney);
        assertThat(vendingMachine.getChanges()).isEqualTo(1500);
    }
}